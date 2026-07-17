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
