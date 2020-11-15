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
 * �ڴ���������㷨�������ƴͼ��Ϸ��N-�������⣩
 */
public class Solution extends Jigsaw {
	private List<JigsawNode> solution;
	private Set<JigsawNode> visited;
	private Queue<JigsawNode> explore; 
	private int num;
	
    /**
     * ƴͼ���캯��
     */	
    public Solution() {
    	super();
    }

    /**
     * ƴͼ���캯��
     * @param bNode - ��ʼ״̬�ڵ�
     * @param eNode - Ŀ��״̬�ڵ�
     */
    public Solution(JigsawNode bNode, JigsawNode eNode) {
        super(bNode, eNode);
    }

    /**
     *��ʵ��һ��������������㷨����ָ��5*5ƴͼ��24-�������⣩�����Ž�
     * ���˺���������Solution���������������������
     * @param bNode - ��ʼ״̬�ڵ�
     * @param eNode - Ŀ��״̬�ڵ�
     * @return �����ɹ�ʱΪtrue,ʧ��Ϊfalse
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
     *��Demo+ʵ��������㲢�޸�״̬�ڵ�jNode�Ĵ��۹���ֵ:f(n)
     * �� f(n) = s(n). s(n)��������ڵ㲻��ȷ���������
     * �˺�����ı�ýڵ��estimatedValue����ֵ
     * �޸Ĵ˺���������Solution���������������������
     * @param jNode - Ҫ������۹���ֵ�Ľڵ�
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