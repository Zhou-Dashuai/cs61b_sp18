public class Planet {
    public double xxPos;    //目前x坐标
    public double yyPos;
    public double xxVel;    //x方向上的速度
    public double yyVel;
    public double mass;    //质量
    public String imgFileName;  //与描绘身体的图像对应的文件的名称
    public static double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
       this.xxPos=p.xxPos;
       this.yyPos=p.yyPos;
       this.xxVel=p.xxVel;
       this.yyVel=p.yyVel;
       this.mass=p.mass;
       this.imgFileName=p.imgFileName;
    }

    public double calcDistance(Planet a) {
        double dX = this.xxPos - a.xxPos;
        double dY = this.yyPos - a.yyPos;
        double r = Math.sqrt(dX*dX+dY*dY);
        return r;
    }

    public double calcForceExertedBy(Planet a) {
        double F = (G*this.mass*a.mass)/(this.calcDistance(a)*this.calcDistance(a));
        return F;
    }

    public double calcForceExertedByX(Planet a) {
        double dX = a.xxPos - this.xxPos;
        double Fx = this.calcForceExertedBy(a)*dX/this.calcDistance(a);
        return Fx;
    }

    public double calcForceExertedByY(Planet a) {
        double dY = a.yyPos - this.yyPos;
        double Fy = this.calcForceExertedBy(a)*dY/this.calcDistance(a);
        return Fy;
    }
public double calcNetForceExertedByX(Planet allPlanets[]) {
        double netForceX = 0.0;
        for(Planet planet : allPlanets) {
            if(!(this.equals(planet))) {
                netForceX += this.calcForceExertedByX(planet);
            }
        }
        return  netForceX;
    }

    public double calcNetForceExertedByY(Planet allPlanets[]) {
        double netForceY = 0.0;
        for(Planet planet : allPlanets) {
            if(!(this.equals(planet))) {
                netForceY += this.calcForceExertedByY(planet);
            }
        }
        return  netForceY;
    }
public void update(double dt,double fX,double fY) {
        this.xxVel+=(fX/this.mass)*dt;
        this.yyVel+=(fY/this.mass)*dt;
        this.xxPos+=this.xxVel*dt;
        this.yyPos+=this.yyVel*dt;
    }
 public void draw() {
        StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
    }
}
