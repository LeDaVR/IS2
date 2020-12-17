#include <iostream>

using namespace std;

class Button
{
    public:
        virtual void paint() = 0;
};

class MacOSButton : public Button{
public:
    void paint(){
        cout << " MacOS Button" << endl;
    }
};

class WindowsButton : public Button{
public:
    void paint(){
        cout << " Windows Button" << endl;
    }
};

class CheckBox
{
    public:
        virtual void paint() = 0;
};

class MacOSCheckBox : public CheckBox{
public:
    void paint(){
        cout << " MacOS CheckBox" << endl;
    }
};

class WindowsCheckBox : public CheckBox{
public:
    void paint(){
        cout << " Windows CheckBox" << endl;
    }
};



class GUIfactory{
    public:
        virtual Button* createButton() = 0;
        virtual CheckBox* createCheckBox() = 0;
};


class MacOSFactory : public GUIfactory{
public:
    Button* createButton(){
        return new MacOSButton();
    }
    CheckBox* createCheckBox(){
        return new MacOSCheckBox();
    }
};


class WindowsFactory : public GUIfactory{
public:
    Button* createButton(){
        return new WindowsButton();
    }
    CheckBox* createCheckBox(){
        return new WindowsCheckBox();
    }
};



class Aplicacion{
    Button* boton;
    CheckBox* checkbox;
public:
    Aplicacion(GUIfactory* factory){
        boton = factory->createButton();
        checkbox = factory->createCheckBox();
    }

    void draw()
    {
        boton->paint();
        checkbox->paint();
    }
    ~Aplicacion()
    {
        delete boton;
        delete checkbox;
    }
};

GUIfactory* configuracion(string OS)
{
    if (OS == "Windows")
        return new WindowsFactory();
    if (OS == "MacOS")
        return new MacOSFactory();
}

int main()
{

    cout <<  "Sistema Operativo Windows" << endl;
    GUIfactory* os = configuracion("Windows");
    Aplicacion aplicacion1(os);
    aplicacion1.draw();
    delete os;

    cout <<  "Sistema Operativo MacOS" << endl;   
    os = configuracion("MacOS");
    Aplicacion aplicacion2(os);
    aplicacion2.draw();
    delete os;

}