/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ep3;

/**
 *
 * @author Luiz Felipe
 */
public class Determinante {
    String[] vetorString;
    double[] vetorDouble;
    
    
    public void setTamanho(int tam){
        this.vetorString = new String[tam];
        this.vetorDouble = new double[tam];
    }
    
    public void setArrayString(String a, int pos){
        vetorString[pos] = a;
    }
    
    public void setArrayDouble(double a, int pos){
        vetorDouble[pos] = a;
    }
    
    public double getArrayDouble(int pos){
        return vetorDouble[pos];
    }
    
    public String getArrayString(int pos){
        return vetorString[pos];
    }
    
    public void internalChangeArrayDouble(int pos1, int pos2){
        vetorDouble[pos1] = vetorDouble[pos2];
    }
    
    public void internalChangeArrayString(int pos1, int pos2){
        vetorString[pos1] = vetorString[pos2];
    }
    
    public boolean arrayStringVazia(){
        if(vetorString[0] == null)
            return true;
        else
            return false;
    }
}
