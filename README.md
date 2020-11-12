Original App Design Project - README Template
===

Food Delivery App

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
Food delivery app that compares pricing for different food delivery apps (UberEats, Grubhub, Doordash, etc.)

### App Evaluation
- **Category:** Service/Food Delivery
- **Mobile:** Primarily developed for mobile devices
- **Story:** Compares prices among food delivery fees for specific restaurants and provides the filtered options to the users
- **Market:** Any individual would be able to use this app
- **Habit:** This app would be used depending on amount of food a user delivers
- **Scope:** Begin by providing best options to user and evolve into placing and tracking orders through the app

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* User should be able to create account, log in, log out
* User should be able to search restaurants in area with filters
* User should be able to view feed of food delivery prices in RecyclerView
* User should be able to see best/cheapest option on top when search completes
* User should be able to use Google Maps API to find restaurants
* User should be able to place order through app

**Optional Nice-to-have Stories**

* User should be able to view more details on restaurant in new activity
* User should be able to track the order by location

### 2. Screen Archetypes

* Login
   * User should be able to login/logout
* Register
   * User should be able to create a new account
* Search and Feed
  * User should be able to see feed of restaurants in the area
  * User should be able to search in bar at the top wth filter
* Restaurant View
  * User should be able to view restaurant information (delivery time, fees, rating, location, menu)
* Maps
  * User should be able to view restaurant location
* (Optional) Cart 
  * User should be able to add menu items to their cart and place order (bottom screen)
* (Optional) Tracking Page
  * User should be able to view Maps fragment and RecyclerView of updates

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Home Feed - view and search restaurants in area
* Profile - login/logout, view past orders(optional)

**Flow Navigation** (Screen to Screen)

* Forced Log In
   * Login if has an account
   * Register if does not have account
* Login/Register
   * Home feed
* Log Out
  * Back to Login 
* Home Feed
  * Map if map selected 
  * Recycler view of search
* Profile
  * About - change info

## Wireframes
[Add picture of your hand sketched wireframes in this section]
<img src="https://i.ibb.co/VQnscxj/Screen-Shot-2020-11-11-at-8-01-57-PM.png" width=600>

### [BONUS] Digital Wireframes & Mockups

### [BONUS] Interactive Prototype

## Schema 
[This section will be completed in Unit 9]
### Models
[Add table of models]
### Networking
- [Add list of network requests by screen ]
- [Create basic snippets for each Parse network request]
- [OPTIONAL: List endpoints if using existing API such as Yelp]
