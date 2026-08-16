public class CollegeData {
        // getters and setters
        private String name = "";
        private String size = "";
        private String type = "";
        private String city =" ";
        private String state = " ";
        //private String adress; //city +", "+ state;
        private double grad= 0;
        private double accept = 0;
        private int found= 0000;
        private int price =0;
        private int zip = 0;
        
        public String getName()
        {
            return name;
        }
        
        public void setName(String name)
        {
            this.name = name;
        }
        
        public String getSize()
        {
            return size;
        }
        
        public void setSize(String Size)
        {
            this.size = Size;
        }
        
        public String getCity()
        {
            return city;
        }
         public void setCity(String city)
         {
             this.city = city;
         }
        
        public String getState()
        {
            return state;
        }
        
        public void setState(String state)
        {
            this.state = state;
        }
        
        
      /*  public void setAdress(String city, String state)
        {
           this.adress = city +", "+ state; 
        }
*/
        public double getGrad()
        {
            return grad;
        }
        
        public void setGrad(double grad)
        {
            this.grad = grad;
        }
        
        public double getAccept()
        {
            return accept;
        }
        
        public void setAccept(double accept)
        {
            this.accept = accept;
        }
        public int getFound()
        {
            return found;
        }
        
        public void setFound(int found)
        {
            this.found = found;
        }
        public int getPrice()
        {
            return price;
        }
        
        public void setPrice(int price)
        {
            this.price = price;
        }
        
        public int getZip()
        {
            return zip;
        }
        
        public void setZip(int zip)
        {
            this.zip= zip;
        }
        public String getSelectedItemSize()
        {
            return size;
        }
        
         public void setSelectedItemSize(String size)
         
         {
             this.size = size;
         }
         public String getSelectedItemType()
        {
            return type;
        }
        
         public void setSelectedItemType(String type)
         
         {
             this.type = type;
         }
        
      
}