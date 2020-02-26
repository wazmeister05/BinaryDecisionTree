// DECISION TREE  APPLICATION
// Frans Coenen
// Thursday 15 August 2002
// Department of Computer Science, University of Liverpool

import java.io.*;

class DecisionTreeApp {

    static BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
    static DecisionTree newTree;

    public static void main(String[] args) throws IOException {

        newTree = new DecisionTree();
        generateTree();
        System.out.println("\nOUTPUT DECISION TREE");
        System.out.println("====================");
        newTree.outputBinTree();
        queryTree();
    }

    static void generateTree() {
        System.out.println("\nGENERATE DECISION TREE");
        System.out.println("======================");
        newTree.createRoot(1,"Does animal eat meat?");
        newTree.addYesNode(1,2,"Does animal have stripes?");
        newTree.addNoNode(1,3,"Does animal have stripes?");
        newTree.addYesNode(2,4,"Animal is a Tiger");
        newTree.addNoNode(2,5,"Animal is a Leopard");
        newTree.addYesNode(3,6,"Animal is a Zebra");
        newTree.addNoNode(3,7,"Animal is a Horse");
    }

    static void queryTree() throws IOException {
        System.out.println("\nQUERY DECISION TREE");
        System.out.println("===================");
        newTree.queryBinTree();

        optionToExit();
    }

    static void optionToExit() throws IOException {
        System.out.println("Exit? (enter \"Yes\" or \"No\")");
        String answer = keyboardInput.readLine();
        if (answer.toLowerCase().equals("Yes")) return;
        else {
            if (answer.toLowerCase().equals("No")) queryTree();
            else {
                System.out.println("ERROR: Must answer \"Yes\" or \"No\"");
                optionToExit();
            }
        }
    }
}