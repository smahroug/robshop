'use strict';

angular
    .module('app.routes', ['ngRoute'])
    .config(config);

function config ($routeProvider) {
    $routeProvider.
        when('/', {
            templateUrl: 'sections/home/home.tpl.html',
            controller: 'HomeController as home'
        })
        .when('/add', {
            templateUrl: 'sections/add/add.tpl.html',
            controller: 'AddController as addCtrl'
        })
        .when('/view/:id', {
            templateUrl: 'sections/add/add.tpl.html',
            controller: 'AddController as addCtrl'
        })
        .otherwise({
            redirectTo: '/'
        });
}