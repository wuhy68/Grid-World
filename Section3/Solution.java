package solution;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import jigsaw.Jigsaw;
import jigsaw.JigsawNode;

/**
 * 在此类中填充算法，完成重拼图游戏（N-数码问题）
 */
public class Solution extends Jigsaw {
	private List<JigsawNode> solution;
	private Set<JigsawNode> visited;
	private Queue<JigsawNode> explore; 
	private int num;
	
    /**
     * 拼图构造函数
     */	
    public Solution() {
    	super();
    }

    /**
     * 拼图构造函数
     * @param bNode - 初始状态节点
     * @param eNode - 目标状态节点
     */
    public Solution(JigsawNode bNode, JigsawNode eNode) {
        super(bNode, eNode);
    }

    /**
     *（实验一）广度优先搜索算法，求指定5*5拼图（24-数码问题）的最优解
     * 填充此函数，可在Solution类中添加其他函数，属性
     * @param bNode - 初始状态节点
     * @param eNode - 目标状态节点
     * @return 搜索成功时为true,失败为false
     */
    public boolean BFSearch(JigsawNode bNode, JigsawNode eNode) {
        this.visited = new HashSet<JigsawNode>(1000);
        Queue<JigsawNode> explore = new LinkedList<JigsawNode>();

        this.beginJNode = new JigsawNode(bNode);
        this.endJNode = new JigsawNode(eNode);
        this.currentJNode = null;

        final int MAX_NODE_NUM = 29000;
        final int DIRS = 4;
		
        this.num = 0;
        this.solution = null;

        this.visited.add(this.beginJNode);
        explore.add(this.beginJNode);

        while (this.num < MAX_NODE_NUM && !explore.isEmpty()) {
            this.num++;

            this.currentJNode = explore.poll();
            if (this.currentJNode.equals(eNode)) {
                this.getPath();
                break;
            }

            JigsawNode[] next = new JigsawNode[]{
                new JigsawNode(this.currentJNode), new JigsawNode(this.currentJNode),
                new JigsawNode(this.currentJNode), new JigsawNode(this.currentJNode)
            };

            for (int i = 0; i < DIRS; i++) {
                if (next[i].move(i) && !this.visited.contains(next[i])) {
                    this.visited.add(next[i]);
                    explore.add(next[i]);
                }
            }
        }

        System.out.println("Jigsaw BFSearch Result:");
        System.out.println("Begin state:" + this.getBeginJNode().toString());
        System.out.println("End state:" + this.getEndJNode().toString());
        System.out.println("Solution Path: ");
        System.out.println(this.getSolutionPath());
        System.out.println("Total number of searched nodes:" + this.num);
        System.out.println("Depth of the current node is:" + this.getCurrentJNode().getNodeDepth());

        return this.isCompleted();
    }

    /**
     *（Demo+实验二）计算并修改状态节点jNode的代价估计值:f(n)
     * 如 f(n) = s(n). s(n)代表后续节点不正确的数码个数
     * 此函数会改变该节点的estimatedValue属性值
     * 修改此函数，可在Solution类中添加其他函数，属性
     * @param jNode - 要计算代价估计值的节点
     */
    public void estimateValue(JigsawNode jNode) {
        int [] initWeights = new int [] {2, 2, 6, 2};

		int wrongNodesAfter = 0; 
		int wrongNodes = 0; 
		int manhattanDistance = 0; 
        int geometryDistance = 0; 
        
		int dim = JigsawNode.getDimension();
		for(int i = 1 ; i < dim * dim; i++){
            if((jNode.getNodesState()[i] + 1) != (jNode.getNodesState()[i + 1]))
                wrongNodesAfter++;
                
			if (jNode.getNodesState()[i] != i && jNode.getNodesState()[0] != i) {
                wrongNodes++;
                
				int x1 = (i - 1) / dim;
				int y1 = (i - 1) % dim;
				int x2 = (jNode.getNodesState()[i] - 1) / dim;
                int y2 = (jNode.getNodesState()[i] - 1) % dim;
                
				manhattanDistance += Math.abs(x1 - x2) + Math.abs(y1 - y2);
				geometryDistance += Math.sqrt(Math.abs(x1 - x2)) + Math.sqrt(Math.abs(y1 - y2));
			}
		}

		jNode.setEstimatedValue(initWeights[0] * wrongNodesAfter + initWeights[1] * wrongNodes + initWeights[2] * manhattanDistance + initWeights[3] * geometryDistance);
    }
}