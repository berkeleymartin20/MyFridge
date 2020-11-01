# MyFridge Android Application #

## Summary ##

Android Application that keeps track of your fridge inventory, as well as items' expiry dates and quantity. 

This project aims to reduce food waste from the forgotten food in the fridge while also reducing number of trips made to grocery stores by keeping a list of food in user's pantry and refrigerator and a list of shopping list made by the user. This application will also keep track of expiry dates of items, and alert the user if an item, or items will be going bad in the near future. 

## Motivation ## 

While applying for jobs, I wanted to keep improving and challenging myself by learning new platforms and languages. Thoroughout my four years and UC Berkeley, I only dealt with backend side of software engineering, from algorithms to data structure, to solve problems and optimize runtime and space efficiency of a program. However, after picking up JavaScript and Node.JS during the past month, I developed an interest in frontend part of software engineering - which led me to app development. Through this project, I plan on showcasing a product that combines backend side of software engineering with frontend side of software engineering to allow users to see and interact with my project.

## Progress ##

- [x] Initialize the overall setup, including layouts, fragments, navigation bar, Xml's for different fragments
- [x] Customize the application to the projects theme, including icons, buttons, fragments, colors, font, and etc. 
- [x] Implement a data structure for Shopping List to keep track of items and their quantities where the items are also accessible by their index
 - [x] Add methods to the data structure to make the items editable 
- [x] Implement an "Add" button for users to add items and their quantities to the shopping lists
- [ ] Implement an "Delete/Edit" button for users to modify their shopping lists
 - [x] Edit TextView for the list of items in Shopping List according to added features
- [x] Implement AddItemFragment and its functionalities. The functions include: enter new item name, enter new quantity and submit
 - [x] Implement a data-checking algorithm to make sure the user can only add new items to the shopping list if data is entered and valid
 
 
 ***More tasks will be added in the future***


## Update Log ##
### 10/28/2020 - 10/31/2020: ###
1. Setup completed, Built ShoppingList class that utilizes a combination of ArrayList and HashMap data structure to keep track of item names and quantity
2. Added Alert,Fridge, and Shopping List Fragment Layouts for different tabs/sections of the application
3. Imported drawables for icons and buttons
4. Bottom Navigation Menu was added to allow the user to switch between different layouts
5. Customized color scheme to make the colors of the app customized to the theme
6. Implemented CardView, CheckBox, TextView in LinearLayout and ConstrainedLayout to better represent the data in ShoppingList
7. Implemented ListAdapter for Shopping List, to initialize the Shopping List section based on the shopping list data given from ShoppingList class

### 11/1/2020: ###

1. Implemented AddItemFragment and its functionalities. The functions include: enter new item name, enter new quantity and submit
2. Implemented a data-checking algorithm to make sure the user can only add new items to the shopping list if data is entered and valid
3. Implemented navigation buttons for data entry and a "back" button to cancel item addition


