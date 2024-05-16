public class MagazzinoSmartphone {
    private Smartphone[] smartphones;
    private int count;

    public MagazzinoSmartphone() {
        smartphones = new Smartphone[10]; // Assuming initial capacity of 10
        count = 0;
    }

    public MagazzinoSmartphone(MagazzinoSmartphone other) {
        this();
        for (int i = 0; i < smartphones.length; i++) {
            if(other.smartphones[i]!=null){
                smartphones[i]=new Smartphone(other.smartphones[i]);
            }
        }
        count=other.count;
    }


    public void addSmartphone(Smartphone smartphone) {
        int i=0;
        boolean messo=false;
        while(getCount()<smartphones.length && i<smartphones.length && !messo){
            if(smartphones[i]==null){
                smartphones[i]=smartphone;
                count++;
                messo=true;
            }
            i++;
        }
        
    }

    public void removeSmartphone(Smartphone smartphone) {
        int i=0;
        boolean trovato=false;
        while(i<getCount() && !trovato){
            if(smartphones[i].equals(smartphone)){
                smartphones[i]=null;
                trovato=true;
            }
            i++;
        }
    }

    public Smartphone[] getSmartphonesArray() {
        Smartphone[] smartphoneArray = new Smartphone[count];
        System.arraycopy(smartphones, 0, smartphoneArray, 0, count);
        return smartphoneArray;
    }


    public Smartphone getSmartphoneByBrand(String brand) {
        Smartphone smartphone = null;
        int i=0;
        boolean trovato=false;
        while(i<smartphones.length && !trovato){
            if(smartphones[i].getBrand().toLowerCase().contains(brand.toLowerCase())){
                smartphone=smartphones[i];
                trovato=true;
            }
            i++;
        }

        return smartphone;
    }

    public MagazzinoSmartphone getSmartphonesByStorageCapacity(int storageCapacity) {
        MagazzinoSmartphone magazzinoSmartphone = new MagazzinoSmartphone();
        int i=0;
        boolean trovato=false;
        while(i<smartphones.length && !trovato){
            if(smartphones[i].getStorageCapacity()==storageCapacity){
                magazzinoSmartphone.addSmartphone(smartphones[i]);
                trovato=true;
            }
            i++;
        }
        return magazzinoSmartphone;
    }

    /*public MagazzinoSmartphone getSmartphonesByPriceRange(double minPrice, double maxPrice) {
        MagazzinoSmartphone magazzinoSmartphone = new MagazzinoSmartphone();

        return magazzinoSmartphone;
    }*/

    @Override
    public String toString() {
        String result = "\nMagazzinoSmartphone:\n";
        for (int i = 0; i < smartphones.length; i++) {
            if(smartphones[i]!=null){
                result+= "Brand: "+smartphones[i].getBrand()+", Model: "+smartphones[i].getModel()
                +", Storage Capacity: "+smartphones[i].getStorageCapacity()+"GB, Price: "+smartphones[i].getPrice()+"\n";
            }
            
        }
        return result;
    }

    public int getCount() {
        return count;
    }

    public boolean equals(Object obj) {
        boolean s=false;
        if(smartphones.equals(((MagazzinoSmartphone)obj).smartphones)){
            s=true;
        }
        return s;
    }


}