public class DetailsView {
    private InitialFrame iframe;
    
    public DetailsView(InitialFrame newiframe){
        this.iframe = newiframe;
    }
    
    public InitialFrame getIframe()               {return this.iframe;}
    public void setIframe(InitialFrame newiframe) {this.iframe = newiframe;}
    
}
