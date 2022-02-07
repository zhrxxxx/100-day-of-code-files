def setup() :
  size(800, 800)
  smooth()
  
def draw():
  background(253)
  stroke(0) 
  noFill()  
  constantFactor = 1.3
  circleSize = 20 
  
  for i in range(0,20):
    strokeWeight(circleSize/25.0) 
    ellipse(width/2,height, circleSize, circleSize)
    circleSize = circleSize * constantFactor 
    



    
