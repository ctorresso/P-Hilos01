public class main implements Runnable{
    int num;
    int v;
    Thread t;

    public main(int num, int v) {
        this.num = num;
        this.v =v;
        t = new Thread(this,"Thread " + num);
        t.start();
    }

    @Override
    public void run() {
        long fact=1;
        for(int i=1;i<=v;i++){
            fact=fact*i;
        }
        System.out.println(t.getName() + " - Factorial de "+v+" es: "+fact);
    }
    public static void main(String[] args) {
        if (args.length == 0){
            System.exit(1);
        }
        for (int i = 0; i < args.length; i++) {
            int v = Integer.parseInt(args[i]);
            main f = new main(i,v);
            try {
                f.t.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
