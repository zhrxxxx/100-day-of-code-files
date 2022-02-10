a = 1  
c, d, e, f = None, None, None, None

def setup():
  size(400, 400)
  global c, d, e, f, a
  c= color(random(255), random(255), random(255))
  d= color(random(255), random(255), random(255))
  e= color(random(255), random(255), random(255))
  f= color(random(255), random(255), random(255))


def draw():
  global c, d, e, f, a
  
  if (a % 3) == 1:
    for x in range(width): # loop through every x
      p = lerpColor(c, d, 1.0 * x/width) # transition smoothly
      stroke(p)
      line(x, 0, x, height)  
  
  elif (a % 3) == 2:
  # double
    for x in range(width): # loop through every x
      p = lerpColor(c, d, 1.0 * x/width) # transition smoothly
      stroke(p)
      line(x, 0, x, height/2)
    
    for x in range(width): # loop through every x
      p = lerpColor(e, f, 1.0 * x/width) # transition smoothly
      stroke(p)
      line(x, height/2, x, height)
 
  elif (a % 3) == 0: 
  # diagonal line
    for x in range(width): # loop through every x
      p = lerpColor(c, d, 1.0 * x/width) # transition smoothly
      stroke(p)
      line(x, 0, x, height)    
    for x in range(width): # loop through every x
      p = lerpColor(e, f, 1.0 * x/width) # transition smoothly
      stroke(p)
      line(x, 0, 0, height)    
    


def mousePressed():
  global c, d, e, f, a
  c= color(random(255), random(255), random(255))
  d= color(random(255), random(255), random(255))
  e= color(random(255), random(255), random(255))
  f= color(random(255), random(255), random(255))
  
  a = a + 1
