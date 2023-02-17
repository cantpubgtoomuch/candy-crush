# Candy Crush

The aim of this work is to create a very reduced version of the game **_Candy Crush_** and thoroughly test all functionalities using Java.

## Functional description

The game consists of a vertically oriented grid of different colored candies. The mechanics of the game lie in choosing a pair of adjacent candies to swap their positions. This exchange is valid only if a valid figure is formed with candies of the same color.

The figures are horizontal or vertical lines of 3, 4 or 5 candies, or a T (of three candies in a line and two perpendicular in the middle) in any orientation, or an L in any orientation.

If the exchange is valid (because one or two figures are formed due to it) the candies that compose them "explode" and disappear. Then the candies that were on top of them fall instead (this is a recursive process).

When certain figures explode they leave special candies in their place, which when they explode generate cascading explosions of different types. Each exploding candy scores the user.

## Levels

### Level 1: Classic   
The objective is to reach the desired score before a certain number of moves.

