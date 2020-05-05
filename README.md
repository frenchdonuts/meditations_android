# Meditations: Surprise yourself with your past thoughts

This is an app I've been thinking about making for a while. Its purpose is to randomly notify the user of heuristics, tidbits of wisdom, etc.
It also serves as a demonstration of my current understanding of Android architecture.

## General architecture

* UI interface: Implementers emit UI events and read off the State that has been computed, turning them into side-effects that render to screen.
*     events :: Unit -> Observable<UI.Event>
*     render :: Observable<UI.UIState> -> Unit
* VM interface: Implementers transform UI events into business-logic Msgs and reduce on those Msgs w/ current state.
*     processEvents :: Observable<UI.Event> -> Unit
*     states :: Unit -> Observable<UI.UIState>
* Dataflow:
*     Data sources (db, network, etc.) -> Interactors --VM.Msg--> ViewModel:VM --UI.UIState--> Fragment:UI
*     Fragment:UI --UI.Event--> ViewModel:VM -> Interactors -> Data sources (db, network, etc.)

## TODO

* [x] Integrate SQLDelight and create Meditations table + queries
* [x] Implement end-to-end data flow for Meditations list screen (one time fetch)
* [ ] Implement reactive data flow for Meditations list screen (introduce RecyclerView DiffUtil)
* [ ] Implement Add Meditations screen
* [ ] Implement random notifications
* [ ] Use Dagger to inject dependencies
* [ ] Break features into separate modules
