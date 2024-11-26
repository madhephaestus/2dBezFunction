import eu.mihosoft.vrl.v3d.CSG
import eu.mihosoft.vrl.v3d.Cube

// code here

double divisions = 30

CSG marker = new Cube(5,2,2).toCSG()
			.toXMax()

double targetX = 100
double targetY = 200

double currentOrentation = -0
double targetOrentation =+180
double handleLength =100;


def p0 = [0,0]
def p1 = [
handleLength * Math.cos(Math.toRadians(currentOrentation)),
handleLength * Math.sin(Math.toRadians(currentOrentation))]
def p2 = [
handleLength * Math.cos(Math.toRadians(180+targetOrentation))+targetX,
handleLength * Math.sin(Math.toRadians(180+targetOrentation))+targetY
]
def p3 = [targetX,targetY]

def parts = []
double previousx = p0[0]
double previousy = p0[1]

for (double t=0;t<1;t+=(1.0/divisions)){

	//println t
	double x = Math.pow((1.0-t),3)*p0[0] +3*Math.pow((1-t),2)*t*p1[0]+3*(1-t)*Math.pow(t,2)*p2[0]+Math.pow(t,3)*p3[0]
	
	double y = Math.pow((1.0-t),3)*p0[1] +3*Math.pow((1-t),2)*t*p1[1]+3*(1-t)*Math.pow(t,2)*p2[1]+Math.pow(t,3)*p3[1]

	double deltaX = previousx-x
	double deltaY = previousy-y
	double angle = Math.toDegrees(Math.atan2(deltaY,deltaX))
	println angle
	
	parts.add(marker
			.rotz(-angle)
		.movex(x)
		.movey(y)
	)
}

return parts