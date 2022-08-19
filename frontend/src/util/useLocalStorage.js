import { useEffect,useState } from "react";

function useLocalState(defaultValue,key){
   const[value,setValue]= useState(()=>{
        const localStorageValue=  localStorage.getItem(key)

        return localStorageValue!=null ?JSON.parse(localStorageValue) :defaultValue;
    });

    useEffect(()=>{
        localStorage.setItem(key,JSON.stringify(value));
    })
    return[value, setValue]//this setValue comes from useState
    //and useEffect changes when the value when new localstorage is set.

}
export {useLocalState};