import React from "react";
import ReactDOM from "react-dom";
import {BrowserRouter, Redirect, Route, Switch} from "react-router-dom";

import Header from "./components/layout/header";
import Footer from "./components/layout/footer";
import Home from "./components/pages/home/home";
import {ProductPage} from "./ProductPage";
import Profile from "./components/pages/profile/profile";
import Filter from "./components/pages/filter/filter";
import Condition from "./components/pages/condition/condition";
import Delivery from "./components/pages/delivery/delivery";
import Confirmation from "./components/pages/confirmation/confirmation";
import Restore from "./components/pages/restore/Restore";
/** CSS Imports */
import "./css/style.css";
/** Font Awesome Icons */
import {library} from "@fortawesome/fontawesome-svg-core";
import {faBars, faEdit, faLaptop, faSave, faTimes,} from "@fortawesome/free-solid-svg-icons";
import {faUserCircle} from "@fortawesome/free-regular-svg-icons";
import {faFacebookSquare, faInstagramSquare, faLinkedin, faTwitterSquare} from "@fortawesome/free-brands-svg-icons";
import {RestoreContextProvider} from "./components/pages/restore/RestoreContext";

/** Font Awesome Icon Library */
library.add(
    faBars,
    faTimes,
    faLaptop,
    faSave,
    faEdit,
    faUserCircle,
    faFacebookSquare,
    faTwitterSquare,
    faInstagramSquare,
    faLinkedin,

);

function notFound() {
    return (
        <div>
            <h2>NOT FOUND: 404</h2>
            <p>ERROR: the page you requested in not available.</p>
        </div>
    );
}

function App() {
    return (
        <React.StrictMode>
            <BrowserRouter>
                <div id='main-container'>
                    <Header/>
                    <Switch>
                        {/* Husk å legge inn routen i no.repairable.backend.controller.ReactForwardController */}
                        <Route exact path={"/"}>
                            {Home}
                        </Route>
                        <Route exact path={"/profile"}>
                            {Profile}
                        </Route>
                        <Route exact path={"/filter"}>
                            {Filter}
                        </Route>
                        <Route exact path={"/condition"}>
                            {Condition}
                        </Route>
                        <Route exact path={"/delivery"}>
                            {Delivery}
                        </Route>
                        <Route exact path={"/confirmation"}>
                            {Confirmation}
                        </Route>
                        <Route exact path={"/restore"}>
                            <RestoreContextProvider>
                                <Restore/>
                            </RestoreContextProvider>
                        </Route>
                        <Route exact path='/product' render={(props) => <ProductPage {...props} />}/> }
                        <Route path='/404' component={notFound}/>
                        <Redirect to='/404'/>
                    </Switch>
                    <Footer/>
                </div>
            </BrowserRouter>
        </React.StrictMode>
    );
}

ReactDOM.render(<App/>, document.getElementById("root"));
