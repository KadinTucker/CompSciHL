/**
 * The pipeline tester class, for handling pipeline nodes
 * Mostly from blue pelican java textbook; 
 * insert method created by Kadin Tucker for
 * Computer Science HL
 */
public class PipelineTester {
    
    private static PipelineNode headNode = null;
    private static PipelineNode tailNode = null;
    
    public static void main(String args[]) {
        append(0, "Pump station");
        append(3050, "Hwy 35");
        append(4573, "Tank farm");
        traverseAndPrint( );
        System.out.println("******* now insert a node before old node 2 *******\n");
        insert(4040, "Cold Creek", 2);
        traverseAndPrint();
    }

    public static void append(int pos, String descr) {
        PipelineNode newNode = new PipelineNode(pos, descr, null);
        if(headNode == null) {
            headNode = newNode;
        } else {
            tailNode.nextNode = newNode;
        }
        tailNode = newNode;
    }
    
    /**
     * Inserts an item into the given index in the list
     */
    public static void insert(int pos, String descr, int index) {
        PipelineNode currentNode = headNode;
        int nodeNum = 0;
        while(currentNode != null && nodeNum < index - 1) {
            nodeNum++;
            currentNode = currentNode.nextNode;
        }
        PipelineNode newNode = new PipelineNode(pos, descr, currentNode.nextNode);
        currentNode.nextNode = newNode;
    }
    
    public static void traverseAndPrint() {
        PipelineNode currentNode = headNode;
        int nodeNum = -1;
        do {
            nodeNum++;
            System.out.println("Node number: " + nodeNum);
            System.out.println("Position: " + currentNode.position);
            System.out.println("Description: " + currentNode.description);
            System.out.println(""); //gives a blank line between nodes
            currentNode = currentNode.nextNode;
        } while(currentNode != null);
    }
}