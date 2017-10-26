//M06 - A01 A view to display the details of a single item (e.g., InstrumentDetailUI in Vintage Sounds).
public class DetailsView {
    private InitialFrame iframe;
    
    public DetailsView(InitialFrame newiframe){
        this.iframe = newiframe;
    }
    
    public InitialFrame getIframe(){
        return this.iframe;
    }
    public void setIframe(InitialFrame newiframe){
        this.iframe = newiframe;
    }
}
