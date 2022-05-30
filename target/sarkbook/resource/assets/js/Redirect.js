function genderChanged(obj)
{
    let value = obj.value;
    if (value === 'all'){
        let x = location.host;
        let URL="https://"+x+"/products?action=display_products";
        location.assign(URL);
    }
    else if (value === 'T-SHIRT'){
        let x = location.host;
        let URL="https://"+x+"/products?action=Tshirt";
        location.assign(URL);
    }
    else if (value === 'SHIRT'){
        let x = location.host;
        let URL="https://"+x+"/products?action=SHIRT";
        location.assign(URL);
    }
}
function genderChangedSort(obj)
{
    let classify=document.getElementById('show-product').innerHTML;
    let value=obj.value;
   
    if (value ==='ASC'){
        if(classify==='T-SHIRT')
        {
            let x = location.host;
            let URL="https://"+x+"/products?action=ASC_T-SHIRT";
            location.assign(URL);
        }
        else if(classify==='SHIRT')
        {
            let x = location.host;
            let URL="https://"+x+"/products?action=ASC_SHIRT";
            location.assign(URL);
        }else{
           
            let x = location.host;
            let URL="https://"+x+"/taobao/products?action=ASCall";
            location.assign(URL);
        }
    }
    else if (value === 'DESC'){
        if(classify==='T-SHIRT')
        {
            let x = location.host;
            let URL="https://"+x+"/products?action=DESC_T-SHIRT";
            location.assign(URL);
        }
        else if(classify==='SHIRT')
        {
            let x = location.host;
            let URL="https://"+x+"/products?action=DESC_SHIRT";
            location.assign(URL);
        }else{
            let x = location.host;
            let URL="https://"+x+"/products?action=DESCall";
            location.assign(URL);
        }
    }
}