# Java-Animation
A collection of particles is contained in a linear chamber. They all have the same speed,  but some are headed toward the right and others are headed toward the left. These  particles can pass through each other without disturbing the motion of the particles, so  all the particles will leave the chamber relatively quickly. 

You will be given the initial conditions by a string 'init' containing at each position an 'L'  for a leftward moving particle, an 'R' for a rightward moving particle, or a '.' for an empty  location. 'init' shows all the positions in the chamber. Initially, no location in the chamber  contains two particles passing through each other.    

We would like an animation of the particles as they move. At each unit of time, we want  a string showing occupied locations with an 'X' and unoccupied locations with a '.'.  Create a method 'animate' that takes a positive integer 'speed' and a string 'init' giving  the initial conditions. The speed is the number of positions each particle moves in one  unit of time. The method will return an array of strings in which each successive element  shows the occupied locations at each time step. The first element of the return should 
show the occupied locations at the initial instant (at time = 0) in the 'X', '.' format. The  last element in the return should show the empty chamber at the first time that it  becomes empty. 

Again, imagine that the method you write will be called thousands of times for varying  initial conditions with size ranging from 0 to 50, and also imagine the case when init is  several hundred thousand locations in size (though with speed > size / 20 or so).  Try to  handle both of these cases efficiently in your implementation.   
