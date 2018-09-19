

export default (state = [], action) =>{
    console.log("In  USERREDUCER", action.type);
// debugger;
    var UPDATE_USER_STATE= "UPDATE_USER_STATE";
    switch (action.type) {
        case UPDATE_USER_STATE : {
            console.log("ACTION PAYLOAD",
                action)
            return action.payload
        }

    }
    return state;
};