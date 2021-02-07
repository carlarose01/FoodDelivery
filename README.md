Outsource Version 2 - Hack-a-thon
===

Outsource

## Table of Contents
1. [Overview](#Overview)
1. [Product Design](#Product-Design)

## Overview
### Description
App developed for communities to outsource the police, who are often harmmful to minority communities.

## Product Design
### Updates
Updated UI/UX
Focused goal of project
Implemented ML/AI Chat bot using Google Cloud Product, Diagflow

## Gif
<img src="https://giphy.com/24afb8a1-8593-4eac-a1b0-f838b2eccd2f" width=300>

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

- [x] User should be able to create account, log in, log out
- [x] User should be able to view feed of posts
- [x] User should be able to create new post with image
- [x] User should be able to view map to see activity going on in their area
- [x] User should be able to tag location when uploading posts
- [x] User should be able to view replies to their post in details view
- [x] User should be able to alert authorities in the need for immediate assistance 

**Optional Nice-to-have Stories**

- [x] User should be able to react (like) to others' posts
- [x] User should be able to reply to others' posts
- [x] User should be able to filter feed based on safety, events, etc.

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
### Models
**Post**
| Property  | Type  | Description  |
|---|---|---|
| id  | String  | unique id (default)  |
| author  | Pointer to User  | image author  |
| image  | File  | image that user posts  |
| caption  | String  | post caption by User  |
| likes  | Array  | array of Users who like Post  |
| createdAt  | DateTime  | date when post is created (default)  |
| updatedAt  | DateTime  | date when post is last updated (default)  |
| location  | GeoPoint  | location where User tags the post  |

**Comment**
| Property  | Type  | Description  |
|---|---|---|
| id  | String  | unique id (default)  |
| author  | Pointer to User  | image author  |
| post  | Pointer to Post  | pointer to post  |
| image  | File  | image that user posts  |
| caption  | String  | post caption by User  |
| likes  | Array  | array of Users that like the comment  |
| createdAt  | DateTime  | date when post is created (default)  |
| updatedAt  | DateTime  | date when post is last updated (default)  |
| location  | GeoPoint  | location where User tags the post  |

**User**
| Property  | Type  | Description  |
|---|---|---|
| id  | String  | unique id (default)  |
| name  | String  | author name  |
| username  | String  | author username  |
| profileImage  | File  | image author  |
| location  | GeoPoint  | current User location  |
| bio  | String  | description of User  |


**Activity**
| Property  | Type  | Description  |
|---|---|---|
| id  | String  | unique id (default)  |
| post  | Pointer to Post  | pointer to post  |
| post  | Pointer to User  | pointer to user  |
| updatedAt  | DateTime  | date when post is updated (likes,comments)  |

### Networking
**List of network requests by screen**
* Home Feed Screen
  * (Read/GET) Query all posts 
  * (Create/POST) Create a new like on a post
  * (Delete) Delete an existing like
  * (Create/POST) Create a new comment on a post
  * (Delete) Delete an existing comment
  * (Create/POST) Create a new post object
  * (Update/PUT) Update post object
* Profile Screen 
  * (Read/GET) Query logged in User object
  * (Update/PUT) Update user profile information
* Maps Screen 
  * (Read/GET) Query all locations tagged in posts
  * (Create/POST) Create new post tagged in location
* Alert Screen - external API
* Activity Screen 
  * (Read/GET) Query all comments and likes on logged in User object posts
  * (Delete) Delete an existing comment
  * (Delete) Delete an existing like

- [OPTIONAL: List endpoints if using existing API such as Yelp]

### Sprint 1 Gif
<img src="https://github.com/carlarose01/SafeCrowd/blob/master/sprint.gif" width=300>

### Sprint 2 Gif
<img src="https://github.com/carlarose01/SafeCrowd/blob/master/sprint2.gif" width=300>

### Sprint 3 Gif
<img src="https://github.com/carlarose01/SafeCrowd/blob/master/ezgif.com-gif-maker.gif" width=300>
