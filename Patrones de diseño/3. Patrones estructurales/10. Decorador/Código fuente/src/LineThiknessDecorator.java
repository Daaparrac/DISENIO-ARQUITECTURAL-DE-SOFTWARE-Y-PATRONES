
public class LineThiknessDecorator extends ShapeDecorator{

    protected double thickness;
    public LineThiknessDecorator(Shape decoratedShape, double thickness) {
              super(decoratedShape);
              this.thickness = thickness;
    }

    @Override
    public void draw() {
              decoratedShape.draw();
              System.out.println("Line thickness: " + thickness);
    }

    // no change in the functionality
    @Override
    public void areaCalc() {
    decoratedShape.areaCalc();
    }

    @Override
    public String description() {
    return decoratedShape.description() + " drawn with line thickness " + thickness + ".";
    }

    // no change in the functionality
    @Override
    public boolean isVisible() {
    return decoratedShape.isVisible();
    }
}
