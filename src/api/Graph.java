package api;

/**
 * Created by lizhaoz on 2016/1/19.
 */

public class Graph {
    private static final String NEWLINE =System.getProperty("line.separator");
    private final int V;//顶点数
    private int E;//边数
    private Bag<Integer>[] adj;
    /**
     * Initializes an empty graph with <tt>V</tt> vertices and 0 edges.
     * param V the number of vertices
     *
     * @param  V number of vertices
     * @throws IllegalArgumentException if <tt>V</tt> < 0
     */
    public Graph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    /**
     * Initializes a new graph that is a deep copy of <tt>G</tt>.
     *
     * @param  G the graph to copy
     */
    public Graph(Graph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }

    private int E() {
        return this.E;
    }
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
    }
    private int V() {
        return this.V;
    }
    /**
     * Adds the undirected edge v-w to this graph.
     *
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     * @throws IndexOutOfBoundsException unless both 0 <= v < V and 0 <= w < V
     */
    public void addEdge(int v,int w){
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }
    /**
     * Returns the vertices adjacent to vertex <tt>v</tt>.
     *
     * @param  v the vertex
     * @return the vertices adjacent to vertex <tt>v</tt>, as an iterable
     * @throws IndexOutOfBoundsException unless 0 <= v < V
     */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }
    /**
     * Returns the degree of vertex <tt>v</tt>.
     *
     * @param  v the vertex
     * @return the degree of vertex <tt>v</tt>
     * @throws IndexOutOfBoundsException unless 0 <= v < V
     */
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }
    /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
    /*
        计算v这个点的深度
     */
    public static int degree(Graph G,int v){
        int degree=0;
        for (int w:G.adj(v)) degree++;
        return degree;
    }
    /*
        计算所有顶点的最大度数
     */
    public static int maxDegree(Graph G){
        int max=0;
        for (int v = 0; v < G.V(); v++) {
            if (degree(G,v)>max)
                max=degree(G,v);
        }
        return max;
    }
    /*
        计算所有顶点的平均度数
     */
    public static double avgDegree(Graph G){
        return 2.0*G.E()/G.V();
    }
    /*
        计算自环的个数
     */
    public static int numberOfSelfLoops(Graph G){
        int count=0;
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v==w)count++;//在这里每条边会记录两次
            }
        }
        return count/2;//每条边都记录过两次
    }

}
