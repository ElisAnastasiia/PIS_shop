package com.shop.Controller.Commands;

public enum ECommand {
    home(new Home()),
    login(new Login()),
    register(new Register()),
    commandLogin(new CommandLogin()),
    commandRegister(new CommandRegister()),
    commandProfile(new CommandProfile()),
    logOut(new CommandLogOut()),
    usersList(new CommandUsersList()),
    deleteUser(new CommandDeleteUser()),
    commandTopUp(new CommandTopUp()),
    productsList(new CommandProductsList()),
    addProduct(new CommandAddProduct()),
    deleteProduct(new CommandDeleteProduct()),
    buyProduct(new CommandBuyProduct())
    ;
    private final ICommand command;
    ECommand(ICommand command) {
        this.command = command;
    }
    public ICommand getCommand() { return command; }
}
