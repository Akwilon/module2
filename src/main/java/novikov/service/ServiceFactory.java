package novikov.service;

public class ServiceFactory {
    private static ServiceFactory instance;
    private final Service textService = new TextService();


    private ServiceFactory() {
    }

    public static ServiceFactory getInstance(){
        if (instance == null){
            instance = new ServiceFactory();
        }
        return instance;
    }

    public Service getTextService(){
        return textService;
    }




}
