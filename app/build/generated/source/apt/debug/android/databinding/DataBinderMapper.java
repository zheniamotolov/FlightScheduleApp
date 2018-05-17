
package android.databinding;
import com.example.android.scheduler_app.BR;
@javax.annotation.Generated("Android Data Binding")
class DataBinderMapper  {
    final static int TARGET_MIN_SDK = 19;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.example.android.scheduler_app.R.layout.fragment_search:
                    return com.example.android.scheduler_app.databinding.FragmentSearchBinding.bind(view, bindingComponent);
                case com.example.android.scheduler_app.R.layout.flight_info:
                    return com.example.android.scheduler_app.databinding.FlightInfoBinding.bind(view, bindingComponent);
                case com.example.android.scheduler_app.R.layout.content_main:
                    return com.example.android.scheduler_app.databinding.ContentMainBinding.bind(view, bindingComponent);
                case com.example.android.scheduler_app.R.layout.airport_item:
                    return com.example.android.scheduler_app.databinding.AirportItemBinding.bind(view, bindingComponent);
                case com.example.android.scheduler_app.R.layout.boarding_info:
                    return com.example.android.scheduler_app.databinding.BoardingInfoBinding.bind(view, bindingComponent);
        }
        return null;
    }
    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case -1648731965: {
                if(tag.equals("layout/fragment_search_0")) {
                    return com.example.android.scheduler_app.R.layout.fragment_search;
                }
                break;
            }
            case 443532649: {
                if(tag.equals("layout/flight_info_0")) {
                    return com.example.android.scheduler_app.R.layout.flight_info;
                }
                break;
            }
            case 731091765: {
                if(tag.equals("layout/content_main_0")) {
                    return com.example.android.scheduler_app.R.layout.content_main;
                }
                break;
            }
            case 1914720637: {
                if(tag.equals("layout/airport_item_0")) {
                    return com.example.android.scheduler_app.R.layout.airport_item;
                }
                break;
            }
            case 1432767069: {
                if(tag.equals("layout/boarding_info_0")) {
                    return com.example.android.scheduler_app.R.layout.boarding_info;
                }
                break;
            }
        }
        return 0;
    }
    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"airport"
            ,"callback"
            ,"isLoading"};
    }
}