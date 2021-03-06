# Freecoin - digital social currency toolkit

[![software by Dyne.org](https://www.dyne.org/wp-content/uploads/2015/12/software_by_dyne.png)](http://www.dyne.org)

Freecoin aims to be a framework for remuneration and authentication supporting multi-sig and off-line transactions on top of multiple blockchain backends. It is open source, written in Clojure and comprising of a REST API and a clean user interface.

[![Build Status](https://travis-ci.org/d-cent/freecoin.svg?branch=master)](https://travis-ci.org/d-cent/freecoin)

## Design

The design of Freecoin is informed by an extensive economic and user-centered research conducted by the D-CENT project and documented in deliverables that are available to the public:

- [Design of Social Digital Currency (D4.4)](http://dcentproject.eu/wp-content/uploads/2015/10/design_of_social_digital_currency_publication.pdf)
- [Implementation of digital social currency infrastructure (D5.5)](http://dcentproject.eu/wp-content/uploads/2015/10/D5.5-Implementation-of-digital-social-currency-infrastructure-.pdf).

More resources can be found on the D-CENT webpage: http://dcentproject.eu/resource_category/publications/

## Configuration

Freecoin identity management is delegated to Stonecutter, the D-CENT SSO. To run Freecoin one also needs to configure integration with a running instance of Stonecutter configured to accept the Freecoin application. The configuration locations are:

- Freecoin: `profiles.clj`
- Stonecutter: `resources/client-credentials.yml`


## Running the app inside a Vagrant virtual machine

Install the **latest** version of Vagrant and VirtualboxISO (be warned, most distributions have outdated packages which won't function well)

Then go into the `ops/` directory in Freecoin and run `vagrant up`, this will create and provision a new virtual machine running Freecoin.

Inside `ops/stonecutter` there is another setup to create and run a local Stonecutter SSO with the same command `vagrant up` given inside it.

## Running the app locally

Install Leiningen and Clojure, then start with

```
lein ring server
```

This command will open a browser on localhost port 8000

## Running the app from a live repl (for developers)

The server can be started and stopped from the repl by doing the following

```
lein repl
user=> (use 'freecoin.core)
user=> (start) ;; starts the server
user=> (stop) ;; stops the server
user=> (use 'freecoin.handlers.debug :reload) (stop) (start) ;; refresh specific namespaces
```

## Live reloading of .clj modules in the repl

Every time you change a file, the tracker will reload it in the
running VM and show a message in the corner of your screen (using
`notify-send`; Linux only for now):

```
lein repl
user=> (use 'freecoin.dev)
user=> (start-nstracker) ;; starts the file change tracker
```


## Running the tests

Freecoin comes complete with test units which are run by the CI but can also be run locally.

For the purpose we use Clojure's `midje` package, to be run with:

```
lein midje
```

See: https://github.com/marick/Midje/wiki/A-tutorial-introduction for advanced testing features.

## REST API

API design is work in progress on http://freecoin.ch/api

## License

Part of Decentralized Citizen Engagement Technologies (D-CENT)

R&D funded by the European Commission (FP7/CAPS 610349)

Copyright (C) 2015 Dyne.org foundation

Copyright (C) 2015 Thoughtworks, Inc.

Designed and maintained by Denis Roio <jaromil@dyne.org>

With contributions by:
- Marco Sachy
- Gareth Rogers
- Duncan Mortimer
- Andrei Biasprozvanny
- Arjan Scherpenisse
- Amy Welch

```
This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
```
