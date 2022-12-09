import { createSlice } from '@reduxjs/toolkit'


export const proyectSlice = createSlice({
    name: 'proyect',
    initialState: {
        list:[]
    },
    reducers: {
        setProyect: (state, action) =>{
            state.list = action.payload
        }
    }
});

export const { setProyect } = proyectSlice.actions;
export default proyectSlice.reducer;

