import java.util.*;
public class Dijkstra {
public static int[] path(int graph[][],int start) {
int n = graph.length;
int distance[] = new int[n];
boolean visited[] = new boolean[n];
Arrays.fill(distance, 999);
distance[start] =0;
for(int i=0;i<n-1;i++) {
int minIndex=-1;
int minDistance = 999;
for(int j=0;j<n;j++) {
if(!visited[j] && distance[j]<minDistance) {
minIndex=j;
minDistance=distance[j];
}
}
visited[minIndex]=true;
for(int k=0;k<n;k++) {
if(!visited[k] && graph[minIndex][k]!=999) {
int newDistance = distance[minIndex] + 
graph[minIndex][k];
 if (newDistance < distance[k]) {
 distance[k] = newDistance;
 }
}
}
}
return distance;
}
public static void main(String[] args) {
// TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);
System.out.println("Number of nodes : ");
int nodes = sc.nextInt();
System.out.println("Nodes: ");
int graph[][] = new int[nodes][nodes];
for(int i=0;i<nodes;i++) {
for(int j=0;j<nodes;j++) {
graph[i][j]=sc.nextInt();
}
}
System.out.println("Enter Starting vertex : ");
int start = sc.nextInt();
int res[] = path(graph,start);
for(int i=0;i<nodes;i++) {
System.out.println("Minimum Distance from "+start+" node to "+i+" - "+res[i]);
}
sc.close();
}
}
