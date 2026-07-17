(ns ct.spools.notebook
  "Capture dated note entries onto strands.

  Public contract: `capture!` plus the `notebook.entry/*` attribute
  vocabulary it writes. Entries are plain strands; anything downstream
  (rendering, digests) reads the vocabulary, never this namespace's
  internals.")

(defn capture!
  "Create an entry strand carrying `notebook.entry/text` and
  `notebook.entry/on` (ISO date). Returns the entry id.

  Fails loudly on blank text — an empty entry is never a sensible
  default."
  [runtime text]
  ;; Sketch for ecosystem modeling: the real body registers via
  ;; skein.api.spool.alpha and validates against ::entry-text.
  (when (or (nil? text) (= "" text))
    (throw (ex-info "notebook entry text must be non-blank" {:text text})))
  {:captured text :runtime (some? runtime)})

(defn capture-on!
  "Capture an entry for an explicit ISO `date`.

  The explicit-date contract that would have broken `capture!` had it
  mutated in place — shipped instead as a new name (v3, accretive).
  `capture!` keeps its implicit-today contract forever."
  [runtime text date]
  (when (nil? date)
    (throw (ex-info "capture-on! requires an explicit date" {:date date})))
  (assoc (capture! runtime text) :on date))
