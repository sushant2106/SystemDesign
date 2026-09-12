public class Service {

    private RecommendationStrategy recommendationStrategy;


    public Service(RecommendationStrategy recommendationStrategy){
        this.recommendationStrategy=recommendationStrategy;
    }


    public void showRecomendation(){
        recommendationStrategy.recommend();
    }
    
}
