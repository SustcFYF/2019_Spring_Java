public class A2Q4 {
    public static void main(String[] args) {
        int n=args[0].length();
        int posi[]=new int[2];
        int br[]=new int[2];
        double num[]=new double[3];
        char cal[]=new char[2];
        int j=0;
        double result=0.0;
        boolean bool=false;
        boolean u=false;
        //find cals
        for(int i=0;i<n;i++){
            switch (args[0].charAt(i)){
                case'(':
                    br[0]=i;
                    bool=true;
                    break;
                case')':
                    br[1]=i;
                    bool=true;
                    break;
                case'+':
                    cal[j]='+';
                    posi[j]=i;
                    j++;
                    break;
                case'-':
                    cal[j]='-';
                    posi[j]=i;
                    j++;
                    break;
                case'*':
                    cal[j]='*';
                    posi[j]=i;
                    j++;
                    break;
                case'/':
                    cal[j]='/';
                    posi[j]=i;
                    j++;
                    break;
                default:break;
            }
        }
        //find nums without brackets
        if(!bool){
            num[0]=Double.parseDouble(args[0].substring(0,posi[0]));
            num[1]=Double.parseDouble(args[0].substring(posi[0]+1,posi[1]));
            num[2]=Double.parseDouble(args[0].substring(posi[1]+1,n));
        }
        //calculate without brackets
        if(!bool){
            if(cal[1]!='*'&&cal[1]!='/'){
                switch (cal[0]){
                    case'+':
                        result=num[0]+num[1];
                        break;
                    case'-':
                        result=num[0]-num[1];
                        break;
                    case'*':
                        result=num[0]*num[1];
                        break;
                    case'/':
                        result=num[0]/num[1];
                        break;
                }
                switch (cal[1]){
                    case'+':
                        result+=num[2];
                        break;
                    case'-':
                        result-=num[2];
                        break;
                }
            }
            else{
                switch (cal[1]){
                    case'*':
                        result=num[1]*num[2];
                        break;
                    case'/':
                        result=num[1]/num[2];
                        break;
                }
                switch (cal[0]){
                    case'+':
                        result+=num[0];
                        break;
                    case'-':
                        result=num[0]-result;
                        break;
                    case'*':
                        result*=num[0];
                        break;
                    case'/':
                        result=num[0]/result;
                        break;
                }
            }
        }
        //find nums with brackets
        if(bool){
            //case : (a_b)_c
            if((br[0]<posi[0])&&(posi[0]<br[1])&&(br[1]<posi[1])){
                num[0]=Double.parseDouble(args[0].substring(br[0]+1,posi[0]));
                num[1]=Double.parseDouble(args[0].substring(posi[0]+1,br[1]));
                num[2]=Double.parseDouble(args[0].substring(posi[1]+1,n));
                switch (cal[0]){
                    case'+':
                        result=num[0]+num[1];
                        break;
                    case'-':
                        result=num[0]-num[1];
                        break;
                    case'*':
                        result=num[0]*num[1];
                        break;
                    case'/':
                        result=num[0]/num[1];
                        break;
                }
                switch (cal[1]){
                    case'+':
                        result+=num[2];
                        break;
                    case'-':
                        result-=num[2];
                        break;
                    case'*':
                        result*=num[2];
                        break;
                    case'/':
                        result/=num[2];
                        break;
                }
            }
            //case : a_(b_c)
            if((posi[0]<br[0])&&(br[0]<posi[1])&&(posi[1]<br[1])){
                num[0]=Double.parseDouble(args[0].substring(0,posi[0]));
                num[1]=Double.parseDouble(args[0].substring(br[0]+1,posi[1]));
                num[2]=Double.parseDouble(args[0].substring(posi[1]+1,br[1]));
                switch (cal[1]){
                    case'+':
                        result=num[1]+num[2];
                        break;
                    case'-':
                        result=num[1]-num[2];
                        break;
                    case'*':
                        result=num[1]*num[2];
                        break;
                    case'/':
                        result=num[1]/num[2];
                        break;
                }
                switch (cal[0]){
                    case'+':
                        result+=num[0];
                        break;
                    case'-':
                        result=num[0]-result;
                        break;
                    case'*':
                        result*=num[0];
                        break;
                    case'/':
                        result=num[0]-result;
                        break;
                }
            }
            //case : (a_b_c)
            if((br[0]<posi[0])&&(posi[1]<br[1])){
                u=true;
                num[0]=Double.parseDouble(args[0].substring(br[0]+1,posi[0]));
                num[1]=Double.parseDouble(args[0].substring(posi[0]+1,posi[1]));
                num[2]=Double.parseDouble(args[0].substring(posi[1]+1,br[1]));
            }
            //case : (a)_b_c
            if((br[0]<posi[0])&&(br[1]<posi[0])){
                u=true;
                num[0]=Double.parseDouble(args[0].substring(br[0]+1,br[1]));
                num[1]=Double.parseDouble(args[0].substring(posi[0]+1,posi[1]));
                num[2]=Double.parseDouble(args[0].substring(posi[1]+1,n));
            }
            //case : a_(b)_c
            if((posi[0]<br[0])&&(br[1]<posi[1])){
                u=true;
                num[0]=Double.parseDouble(args[0].substring(0,posi[0]));
                num[1]=Double.parseDouble(args[0].substring(br[0]+1,br[1]));
                num[2]=Double.parseDouble(args[0].substring(posi[1]+1,n));
            }
            //case : a_b_(c)
            if((posi[1]<br[0])&&(posi[1]<br[1])){
                u=true;
                num[0]=Double.parseDouble(args[0].substring(0,posi[0]));
                num[1]=Double.parseDouble(args[0].substring(posi[0]+1,posi[1]));
                num[2]=Double.parseDouble(args[0].substring(br[0]+1,br[1]));
            }
            if(u){
                if(cal[1]!='*'&&cal[1]!='/'){
                    switch (cal[0]){
                        case'+':
                            result=num[0]+num[1];
                            break;
                        case'-':
                            result=num[0]-num[1];
                            break;
                        case'*':
                            result=num[0]*num[1];
                            break;
                        case'/':
                            result=num[0]/num[1];
                            break;
                    }
                    switch (cal[1]){
                        case'+':
                            result+=num[2];
                            break;
                        case'-':
                            result-=num[2];
                            break;
                    }
                }
                else{
                    switch (cal[1]){
                        case'*':
                            result=num[1]*num[2];
                            break;
                        case'/':
                            result=num[1]/num[2];
                            break;
                    }
                    switch (cal[0]){
                        case'+':
                            result+=num[0];
                            break;
                        case'-':
                            result=num[0]-result;
                            break;
                        case'*':
                            result*=num[0];
                            break;
                        case'/':
                            result=num[0]/result;
                            break;
                    }
                }
            }
        }
        System.out.printf("%.2f",result);
    }
}

