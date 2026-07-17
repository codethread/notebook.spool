# notebook.spool

A worked-example "key community spool": capture notes onto strands and
digest them later. One repo, one release unit, two roots consumed as a
family: `ct.spools/notebook` (capture) and `ct.spools/review` (digest).

## Release regime

Accretion only under a name. Tags are ordered release markers bound to
shas (`v1`, `v2`, ...) — the sha is what a consumer trusts, the tag is
the human change signal. A change that would reject input the published
contract accepts is a break, and a break ships as a **new name** (new
root or namespace), never as a mutation of this one.

## Extension point

`review` renders any `notebook.section/*` attribute it finds on an entry
strand, in attribute-name order. Other spools contribute sections by
stamping that vocabulary — this spool never knows they exist. (The same
open-keyword composition as skein's workflow/agent-run `:subagent`.)

## Consuming

```clojure
;; .skein/spools.edn — one entry for the whole family
{:spools
 {ct.spools/notebook-spool
  {:git/url "https://github.com/codethread/notebook.spool.git"
   :git/tag "v2"
   :git/sha "<sha of v2>"
   :roots   {ct.spools/notebook "notebook"
             ct.spools/review   "review"}}}}
```
