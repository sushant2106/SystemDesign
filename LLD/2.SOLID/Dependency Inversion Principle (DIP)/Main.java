public class Main {


    public static void main(String[] args) {
        

        Service service=new Service(new TrendingRecommendation());

        service.showRecomendation();
    }
    
}
