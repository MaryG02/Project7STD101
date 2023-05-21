package Part2;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(
                50,
                    new BinaryTree<>(
                            17,
                            new BinaryTree<>(
                                    12,
                                    new BinaryTree<>(
                                            9),
                                    new BinaryTree<>(
                                            14)),
                            new BinaryTree<>(
                                    23,
                                    new BinaryTree<>(
                                            19),
                                    new BinaryTree<>()) ),
                    new BinaryTree<>(
                            72,
                            new BinaryTree<>(
                                    54,
                                    new BinaryTree<>(),
                                    new BinaryTree<>(
                                            67)),
                            new BinaryTree<>(
                                    76)
                                     )

        );

        System.out.println("Inorder traverse:");
        tree.inorderTraverse(new BinaryTreeVisitor<>());
        System.out.println();
        System.out.println("Postorder traverse: ");
        tree.postorderTraverse(new BinaryTreeVisitor());
        System.out.println();
        System.out.println("Preorder traverse:");
        tree.preorderTraverse(new BinaryTreeVisitor<>());
        System.out.println();
        System.out.println("Size of the tree is: "+ tree.getSize());
        System.out.println("Traverse with iterator:");
        for (Integer i: tree) {
            System.out.print(i + " ");
        }
    }
}
