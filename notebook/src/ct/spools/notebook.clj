(ns ct.spools.notebook
  "Capture dated note entries onto strands.

  Public contract: `capture!` plus the `notebook.entry/*` attribute
  vocabulary it writes. Entries are plain strands; anything downstream
  (rendering, digests) reads the vocabulary, never this namespace's
  internals.")

(defn capture!
  "Create an entry strand carrying `notebook.entry/text` and
  `notebook.entry/on`. Returns the entry id.

  Requires an explicit ISO `date` — the old implicit-today default is
  gone. Fails loudly on blank text or missing date."
  [runtime text date]
  ;; Sketch for ecosystem modeling: the real body registers via
  ;; skein.api.spool.alpha and validates against ::entry-text.
  (when (or (nil? text) (= "" text))
    (throw (ex-info "notebook entry text must be non-blank" {:text text})))
  (when (nil? date)
    (throw (ex-info "capture! requires an explicit date" {:date date})))
  {:captured text :on date :runtime (some? runtime)})
