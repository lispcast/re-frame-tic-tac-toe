# tic-tac-toe

Code for a Tic-Tac-Toe implementation in re-frame.

This code is part of the [re-frame in one hour][lesson] exploration,
part of [*PurelyFunctional.tv Online Mentoring*][ment].

[lesson]: https://purelyfunctional.tv/clojure-in-one-hour/re-frame-in-one-hour/
[ment]: https://purelyfunctional.tv/

## Development Mode

### Start Cider from Emacs:

Put this in your Emacs config file:

```
(setq cider-cljs-lein-repl "(do (use 'figwheel-sidecar.repl-api) (start-figwheel!) (cljs-repl))")
```

Navigate to a clojurescript file and start a figwheel REPL with `cider-jack-in-clojurescript` or (`C-c M-J`)

### Run application:

```
lein clean
lein figwheel dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

## Production Build

```
lein clean
lein cljsbuild once min
```

