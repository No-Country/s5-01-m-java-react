import { configureStore } from '@reduxjs/toolkit'
import user from './slices/user'
import proyect from './slices/proyect'

export default configureStore({
    reducer:{
        user,
        proyect
    }
})