package com.rental.QO;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.rental.entity.LocationCar;




public class LocationCarForm extends BaseInfoForm {

                        /**
    * Node number
    */
        private Integer locationId;
                /**
    * The vehicle number
    */
        private Integer cid;
        

        public LocationCar toLocationCar(LocationCar entity) {
                   if(this.locationId != null) {
                entity.setLocationId(this.locationId);
            }
                   if(this.cid != null) {
                entity.setCid(this.cid);
            }
                return entity;
    }


        public Wrapper<LocationCar> toWrapper() {
        Wrapper<LocationCar> wrapper = new EntityWrapper<>();
                                            if(this.locationId != null) {
                                    wrapper.eq("location_id",this.locationId);
                            }
                                            if(this.cid != null) {
                                    wrapper.eq("cid",this.cid);
                            }
                return wrapper;
    }


                                        
        public Integer getLocationId() {
        return locationId;
        }

                        public void setLocationId(Integer locationId) {
                    this.locationId = locationId;
                    }
                                
        public Integer getCid() {
        return cid;
        }

                        public void setCid(Integer cid) {
                    this.cid = cid;
                    }
            
        @Override
    public String toString() {
    return "LocationCar{" +
                                "locationId=" + locationId +
                                            ", cid=" + cid +
                        "}";
    }
}
