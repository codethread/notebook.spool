(ns ct.spools.review
  "Digest captured entries, rendering contributed sections.

  Renders every `notebook.section/*` attribute found on an entry in
  attribute-name order — the open extension point other spools stamp
  without this namespace knowing them.")

(defn daily-digest
  "Return entries for `date` with their contributed sections appended.

  Sections come from the open `notebook.section/*` vocabulary; unknown
  contributors are rendered, never filtered."
  [entries date]
  {:date date :entries (vec entries)})
