package com.gt.magicboxshop.app;

import android.util.ArrayMap;

import com.gt.magicboxshop.utils.AppUtils;


public class Configurator {

    private static final ArrayMap<String,Object> PLANE_CONFIGS = new ArrayMap<>();
    private SystemType defuleType = SystemType.ALLIANCE;
    /**
     * 配置没有初始化
     */
    private Configurator() {
        PLANE_CONFIGS.put(ConfigType.CONFIG_READY.name(),false);
    }

    public final ArrayMap<String,Object> getPlaneConfigs(){
        return PLANE_CONFIGS;
    }

    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }

    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    public final void configure(){
        PLANE_CONFIGS.put(ConfigType.CONFIG_READY.name(),true);
    }

    /**
     *  检查是否已经初始化了（是否调用了configure（））
     */
    private static final void checkConfigure(){
        boolean isReady = (boolean)PLANE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if(!isReady){
            throw  new RuntimeException("Configurator is no ready , please call configure");
        }
    }

   public static final <T> T getConfiguration(Enum<ConfigType> key){
        checkConfigure();
        return (T)PLANE_CONFIGS.get(key.name());
    }

    public final Configurator withApiHostType(SystemType type){
        defuleType = type;
        return  this;
    }

    public final Configurator withApiHost(SystemType type){
        if(defuleType == SystemType.ALLIANCE){
            switch (type){
                case TEST_TYPE:
                    PLANE_CONFIGS.put(ConfigType.API_HOST.name(),"https://union.deeptel.com.cn/app/starcard/android/"+ AppUtils.getAppVersionCode()+"/");
                    break;
                case FORT_TYPE:
                    PLANE_CONFIGS.put(ConfigType.API_HOST.name(),"https://nb.union.deeptel.com.cn/app/starcard/android/"+AppUtils.getAppVersionCode()+"/");
                    break;
                case FORMAL_TYPE:
                    PLANE_CONFIGS.put(ConfigType.API_HOST.name(),"https://alliance.duofriend.com/app/starcard/android/"+AppUtils.getAppVersionCode()+"/");
                    break;
                default:
                    break;
            }
        }else if(defuleType == SystemType.YIDIAN){
            switch (type){
                case TEST_TYPE:
                    PLANE_CONFIGS.put(ConfigType.API_HOST.name(),"https://shop.deeptel.com.cn/");
                    break;
                case FORT_TYPE:
                    PLANE_CONFIGS.put(ConfigType.API_HOST.name(),"https://nb.shop.deeptel.com.cn/");
                    break;
                case FORMAL_TYPE:
                    PLANE_CONFIGS.put(ConfigType.API_HOST.name(),"https://shop.duofriend.com/");
                    break;
//                case TEST_TYPE2:
//                    PLANE_CONFIGS.put(ConfigType.API_HOST.name(),"https://yj.deeptel.com.cn/");
//                    break;
//                case FORMAL_TYPE2:
//                    PLANE_CONFIGS.put(ConfigType.API_HOST.name(),"https://yj.duofriend.com/");
//                    break;
                default:
                    break;
            }
        }

        return this;
    }




    public final Configurator withLogcatSwitch(boolean sticth){
        PLANE_CONFIGS.put(ConfigType.LOGCAT_STITCH.name(),sticth);
        return this;
    }






}
