package Part2;

public class BinaryTreeVisitor<T> implements Visitor<T> {


    @Override
    public void visit(T data) {
        System.out.print(data + " ");
    }
}
