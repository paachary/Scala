
class JavaClass {
    
    private int index;
    private String name;
    
    public JavaClass(int index, String name) {
        this.index = index;
        this.name = name;
    }
    
    public void printString() {
        System.out.println("index = "+ this.index +": name = "+ this.name);
    }
}
