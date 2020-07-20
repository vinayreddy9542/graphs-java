/*
ArrayList<ArrayList<Integer>> g: represent graph containing 'V' number of
                                    vertices and edges between them
V: represent number of vertices
*/
class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int v)
    {
       boolean[] visited = new boolean[v];
       Stack<Integer> stk = new Stack<>();
       for(int i=0;i<v;i++){
           if(visited[i]==false){
               visited[i]=true;
               stk.push(i);
               while(!stk.isEmpty()){
                   int adj = getadj(g,visited,stk.peek());
                   if(adj==-1){
                       stk.pop();
                   }
                   else if(adj==-2){
                       return true;
                   }
                   else{
                       g.get(adj).remove(new Integer(stk.peek()));
                       g.get(stk.peek()).remove(new Integer(adj));
                       stk.push(adj);
                       visited[adj]=true;
                   }
               }
           }
           else{
               continue;
           }
       }
       return false;
    }
    static int getadj(ArrayList<ArrayList<Integer>> g,boolean[] visited,int p){
        ArrayList<Integer> list = g.get(p);
        for(int x:list){
            if(visited[x]==false){
                return x;
            }
            else{
                return -2;
            }
        }
        return -1;
    }
}
