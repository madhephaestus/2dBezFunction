// code here

double divisions = 30

CSG marker = new Cube(2).toCSG()

double targetX = 100
double targetY = 200

def p0 = [0,0]
def p1 = [-100,0]
def p2 = [150,50]
def p3 = [targetX,targetY]

def parts = []
for (double t=0;t<1;t+=(1.0/divisions)){

	println t
	double x = Math.pow((1.0-t),3)*p0[0] +3*Math.pow((1-t),2)*t*p1[0]+3*(1-t)*Math.pow(t,2)*p2[0]+Math.pow(t,3)*p3[0]
	
	double y = Math.pow((1.0-t),3)*p0[1] +3*Math.pow((1-t),2)*t*p1[1]+3*(1-t)*Math.pow(t,2)*p2[1]+Math.pow(t,3)*p3[1]

	parts.add(marker
		.movex(x)
		.movey(y)
	)
}

return parts