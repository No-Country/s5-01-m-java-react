import { createSlice } from '@reduxjs/toolkit'


export const userSlice = createSlice({
    name: 'user',
    initialState: {
        list:[]
    },
    reducers: {
        setUserData: (state, action) =>{
            state.list = action.payload
        }
    }
});

export const { setUserData } = userSlice.actions;
export default userSlice.reducer;

