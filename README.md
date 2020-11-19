Original App Design Project - README Template
===

Safety Crowdsourcing App

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
Safety crowdsourcing app developed for communities to remain safe reporting suspicious activity, events, etc using crowdsourcing.

### App Evaluation
- **Category:** Social Media/Safety
- **Mobile:** Primarily developed for mobile devices
- **Story:** Provides space for community to post information about activity occurring around them
- **Market:** Any individual would be able to use this app
- **Habit:** This app would be used depending on amount of people that contribute to crowdsourcing
- **Scope:** Begin by displaying upload and feed features then add location services

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* User should be able to create account, log in, log out
* User should be able to view feed of posts
* User should be able to create new post with image
* User should be able to view map to see activity going on in their area
* User should be able to tag location when uploading posts
* User should be able to view replies to their post in details view
* User should be able to alert authorities in the need for immediate assistance 

**Optional Nice-to-have Stories**

* User should be able to react to others' posts
* User should be able to reply to others' posts
* User should be able to filter feed based on safety, events, etc.

### 2. Screen Archetypes

* Login
   * User should be able to login/logout
* Register
   * User should be able to create a new account
* Feed
  * User should be able to view feed of posts
* Create Post
  * User should be able to create post with image and location
* Maps
  * User should be able to view activity with pins on the map of their location
* Profile
  * User should be able to view profile, log out, and edit user information
* Emergency 
  * User should be able to alert authorities in the need for immediate assistance 

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Home Feed - view posts of user
* Profile - login/logout, edit user information
* Alert - alert authorities of important information
* Map - view location with pins where activity posts are
* Activity(Optional) - view replies and reactions to user posts

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
<img src="https://i.ibb.co/RPRVQz5/Screen-Shot-2020-11-18-at-3-08-45-PM.png" width=600>

### [BONUS] Digital Wireframes & Mockups
<img src="" width=600>
### [BONUS] Interactive Prototype

## Schema 
[This section will be completed in Unit 9]
### Models
Post
| Property  | Type  | Description  |
|---|---|---|
| id  |   |   |
| author  |   |   |
| image  |   |   |
| caption  |   |   |
| commentsCount  |   |   |
| likesCount  |   |   |
| createdAt  |   |   |
| updatedAt  |   |   |
| location  |   |   |
### Networking
- [Add list of network requests by screen ]
- [Create basic snippets for each Parse network request]
- [OPTIONAL: List endpoints if using existing API such as Yelp]
