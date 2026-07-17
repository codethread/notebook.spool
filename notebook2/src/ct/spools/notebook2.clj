(ns ct.spools.notebook2
  "Second-generation capture: explicit dates everywhere.

  The rework that would have broken `ct.spools.notebook` had it mutated
  in place — shipped instead as a sibling root. Consumers opt in by
  activating this root; the original keeps its contract forever. Wire
  surfaces that changed take new names too (ops registered by this root
  are `notebook2 ...` verbs — a root never re-registers a sibling's
  verbs with different behavior)."
  (:require [ct.spools.notebook :as notebook1]))

(defn capture!
  "Capture an entry for an explicit ISO `date`; no implicit today.

  The good name reclaimed under a new namespace — legal because opting
  into this root is the consumer's explicit choice."
  [runtime text date]
  (when (nil? date)
    (throw (ex-info "notebook2 capture! requires an explicit date"
                    {:date date})))
  (assoc (notebook1/capture! runtime text) :on date))
