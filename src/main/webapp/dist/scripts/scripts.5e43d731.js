"use strict";angular.module("scheckcheckUiApp",["ngAnimate","ngCookies","ngResource","ngRoute","ngSanitize","ngTouch","ui.sortable","LocalStorageModule"]).config(["$routeProvider",function(a){a.when("/",{templateUrl:"views/main.html",controller:"MainCtrl"}).when("/about",{templateUrl:"views/about.html",controller:"AboutCtrl"}).when("/login",{templateUrl:"views/login.html",controller:"LoginCtrl"}).when("/profil",{templateUrl:"views/profil.html",controller:"ProfilCtrl"}).when("/bildungstraegerList",{templateUrl:"views/bildungstraegerList.html",controller:"BildungstraegerListCtrl"}).when("/bildungsmassnahmeList",{templateUrl:"views/bildungsmassnahmeList.html",controller:"BildungsmassnahmeListCtrl"}).when("/bewertungErstellen",{templateUrl:"views/bewertungErstellen.html",controller:"BewertungErstellenCtrl"}).when("/bildungstraeger",{templateUrl:"views/bildungstraeger.html",controller:"BildungstraegerCtrl"}).when("/bildungsmassnahme",{templateUrl:"views/bildungsmassnahme.html",controller:"BildungsmassnahmeCtrl"}).when("/bewertung",{templateUrl:"views/bewertung.html",controller:"BewertungCtrl"}).otherwise({redirectTo:"/"})}]),angular.module("scheckcheckUiApp").controller("MainCtrl",["$scope",function(a){a.awesomeThings=["HTML5 Boilerplate","AngularJS","Karma"]}]),angular.module("scheckcheckUiApp").controller("AboutCtrl",["$scope",function(a){a.awesomeThings=["HTML5 Boilerplate","AngularJS","Karma"]}]),angular.module("scheckcheckUiApp").controller("LoginCtrl",["$scope",function(a){a.awesomeThings=["HTML5 Boilerplate","AngularJS","Karma"]}]),angular.module("scheckcheckUiApp").controller("ProfilCtrl",["$scope",function(a){a.awesomeThings=["HTML5 Boilerplate","AngularJS","Karma"]}]),angular.module("scheckcheckUiApp").controller("BildungstraegerListCtrl",["$scope",function(a){a.awesomeThings=["HTML5 Boilerplate","AngularJS","Karma"]}]),angular.module("scheckcheckUiApp").controller("BildungsmassnahmeListCtrl",["$scope",function(a){a.awesomeThings=["HTML5 Boilerplate","AngularJS","Karma"]}]),angular.module("scheckcheckUiApp").controller("BewertungErstellenCtrl",["$scope",function(a){a.awesomeThings=["HTML5 Boilerplate","AngularJS","Karma"]}]),angular.module("scheckcheckUiApp").controller("BildungstraegerCtrl",["$scope",function(a){a.awesomeThings=["HTML5 Boilerplate","AngularJS","Karma"]}]),angular.module("scheckcheckUiApp").controller("BildungsmassnahmeCtrl",["$scope",function(a){a.awesomeThings=["HTML5 Boilerplate","AngularJS","Karma"]}]),angular.module("scheckcheckUiApp").controller("BewertungCtrl",["$scope",function(a){a.awesomeThings=["HTML5 Boilerplate","AngularJS","Karma"]}]);